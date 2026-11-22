package com.yetiantian.campus_erp.service;

import com.yetiantian.campus_erp.domain.Application;
import com.yetiantian.campus_erp.domain.Member;
import com.yetiantian.campus_erp.domain.Project;
import com.yetiantian.campus_erp.domain.State;
import com.yetiantian.campus_erp.repository.ApplicationRepository;
import com.yetiantian.campus_erp.repository.MemberRepository;
import com.yetiantian.campus_erp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ApplicationService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ApplicationRepository applicationRepository;

    @Transactional
    public Application submit(Long projectId, Long applicantId, String purpose, BigDecimal amount) {
        // 1. 查项目和申请人（不存在就抛异常）
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("项目不存在"));
        Member applicant = memberRepository.findById(applicantId).orElseThrow(() -> new RuntimeException("申请人不存在"));
        // 2. 校验 purpose 非空、amount > 0
        if (purpose == null || purpose.trim().isEmpty()) {
            throw new RuntimeException("用途不能为空");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("金额必须大于0");
        }
        if (amount.scale() > 2) {
            throw new RuntimeException("金额最多两位小数");
        }
        // 3. 算出冻结总额，检查钱够不够
        BigDecimal frozenAmount = sumFrozen(projectId);
        BigDecimal usedAmount = sumUsed(projectId);

        BigDecimal available = project.getTotalAmount()
                .subtract(frozenAmount)
                .subtract(usedAmount);

        if (available.compareTo(amount) < 0) {
            throw new RuntimeException("经费不足");
        }

        // 4. 创建 Application，设状态为 PENDING_L1
        Application application = new Application();
        application.setProject(project);
        application.setApplicant(applicant);
        application.setPurpose(purpose);
        application.setApplyAmount(amount);
        application.setState(State.PENDING_L1);
        application.setCreatedAt(LocalDateTime.now());
        // 5. 保存并返回
        return applicationRepository.save(application);

    }

    public BigDecimal sumFrozen(Long projectId) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Application a : applicationRepository.findByProjectId(projectId)) {
            if (a.getState() == State.PENDING_L1) {
                sum = sum.add(a.getApplyAmount());
            } else if (a.getState() == State.APPROVED) {
                sum = sum.add(a.getApprovedAmount());
            }
        }
        return sum;
    }

    public BigDecimal sumUsed(Long projectId) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Application a : applicationRepository.findByProjectId(projectId)) {
            if (a.getState() == State.SETTLED) {
                sum = sum.add(a.getActualAmount());
            }
        }
        return sum;
    }
}
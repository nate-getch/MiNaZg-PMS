package com.minazg.service;


import com.minazg.model.Release;
import com.minazg.model.StatusType;
import com.minazg.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseRepository releaseRepository;

    @Override
    public Release findByVersionNumber(String versionNumber) {
        return releaseRepository.findByVersionNumber(versionNumber);
    }

    @Override
    public List<Release> findReleaseByProjectId(Long projectId) {
        return releaseRepository.findReleaseByProjectId(projectId);
    }

    @Override
    public void saveRelease(Release release) {
        releaseRepository.saveRelease(release);
    }

    @Override
    public void updateRelease(String versionNumber, StatusType statusType) {
        releaseRepository.updateRelease(versionNumber, statusType);
    }

    @Override
    public void updateRelease(String versionNumber, String remark) {
        releaseRepository.updateRelease(versionNumber, remark);
    }


}

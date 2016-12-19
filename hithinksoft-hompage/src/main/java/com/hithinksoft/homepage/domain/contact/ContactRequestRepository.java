package com.hithinksoft.homepage.domain.contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lzs on 2016/7/25.
 */
public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {
    Page<ContactRequest> findByContactRequestStatus(ContactRequestStatus contactRequestStatus, Pageable pageable);

    Page<ContactRequest> findByContactRequestStatusIn(Pageable pageable, ContactRequestStatus... contactRequestStatuses);

}

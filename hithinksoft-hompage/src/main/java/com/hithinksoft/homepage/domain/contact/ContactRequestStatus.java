package com.hithinksoft.homepage.domain.contact;

import com.hithinksoft.homepage.domain.shared.ValueObject;

/**
 * Created by Shuzhen on 2016/8/23.
 */
public enum ContactRequestStatus implements ValueObject<ContactRequestStatus> {
    UNREAD("未读"), READ("已读"), DELETE("删除"), COMPLETELYDELETE("彻底删除");
    private String status;

    private ContactRequestStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean sameValueAs(ContactRequestStatus other) {
        return other == this;
    }
}

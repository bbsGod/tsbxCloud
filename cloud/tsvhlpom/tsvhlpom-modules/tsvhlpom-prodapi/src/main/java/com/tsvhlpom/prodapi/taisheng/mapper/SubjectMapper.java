package com.tsvhlpom.prodapi.taisheng.mapper;

import com.tsvhlpom.prodapi.taisheng.VO.Subject;

public interface SubjectMapper {
    Subject getAppSubject(String appNo);
    Subject getInsSubject(String appNo);
}

package com.thanos.api.service;

import com.thanos.api.domain.Code;
import com.thanos.api.repository.CodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class CodeService {


    private final CodeRepository codeRepository;


    public Code createBy() {
        Code code = Code.of((long) 1, null, "공통코드", "KR", "Y");
        return codeRepository.save(code);
    }

    public Code modifyBy() {
        Code updateCode = codeRepository.getOne((long)1);
        //updateCode.setCodeName("수정된 코드");

        return codeRepository.save(updateCode);
    }
}

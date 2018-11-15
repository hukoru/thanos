package com.thanos.api.repository;

import com.thanos.api.domain.Code;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "development")
public class CodeRepositoryTest {

    @MockBean
    private CodeRepository codeRepository;

    private String codeName;
    private String languageCode;
    private Long codeId;

    @Before
    public void setUp() {

    }

    @Test
    public void insertCodeTest() {
        Code code = Code.of((long) 1, null, "공통코드", "KR", "Y");
        codeRepository.save(code);

        List<Code> codeList = codeRepository.findAll();

        codeId = code.getCodeId();
        codeName = code.getCodeName();
        languageCode = code.getLanguageCode();

        Assert.assertEquals(new Long(1), codeId);
        Assert.assertEquals("공통코드", codeName);
        Assert.assertEquals("KR", languageCode);

        System.out.println(codeList.size());
    }

    @Test
    public void updateCodeTest() {
        Code code = Code.of((long) 1, null, "공통코드", "KR", "Y");
        codeRepository.save(code);
        code = Code.of((long) 2, null, "공통코드2", "KR", "Y");
        codeRepository.save(code);

        Code resultCode = codeRepository.getOne((long)2);

        codeRepository.save(resultCode);
    }
}

package com.thanos.api.repository;

import com.thanos.api.domain.Code;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
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

     /*   LocalDateTime now = LocalDateTime.now();

        Code code = Code.of((long) 1, null, "공통코드", "KR", "Y", (long)1, (long)1);
        codeRepository.save(code);


        codeId = code.getCodeId();
        codeName = code.getCodeName();
        languageCode = code.getLanguageCode();
        //insertDate*/

    }

    @Test
    public void inserCodeTest() {
        Code code = Code.of((long) 1, null, "공통코드", "KR", "Y", (long)1, (long)1);
        codeRepository.save(code);

        List<Code> codeList = codeRepository.findAll();

        Assert.assertEquals(new Long(1), codeId);
        Assert.assertEquals("공통코드", codeName);
        Assert.assertEquals("KR", languageCode);

        System.out.println(codeList.size());
    }
}

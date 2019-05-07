package com.mycompany.desafio.api.services;

import com.mycompany.desafio.api.base.dto.JDTOUtils;
import com.mycompany.desafio.api.base.exception.ServiceException;
import com.mycompany.desafio.api.base.service.JEventService;
import com.mycompany.desafio.api.dtos.JPessoasDto;
import com.mycompany.desafio.api.entities.JPessoa;
import java.util.Objects;
import java.util.Optional;
import javax.validation.ConstraintViolationException;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
@Profile("test")
public class JPessoaServiceTest {

    @Autowired
    private IPessoaService service;

    private static boolean dataLoaded = false;
    private static Long lastCodigoSave = 0L;

    @Before
    public void init() throws ServiceException {
        if (!dataLoaded) {
            JPessoa pessoa = new JPessoa();
            pessoa.setCep("1111111");
            pessoa.setCodigoTipoEndereco(1);
            pessoa.setIdade(25);
            pessoa.setNome("Eduardo");
            pessoa.setNomeEndereco("São Paulo");
            pessoa.setNumero("555");

            service.save(JEventService.from(pessoa));
            
            dataLoaded = true;
        }
    }
    
    @Test
    public void filterPessoaComSucesso() throws ServiceException {
        Page<JPessoa> pessoas = service.filter(null, null, "");
        assertNotNull(pessoas);
    }

    @Test
    public void savePessoaComSucesso() throws ServiceException {
        JPessoa pessoa = new JPessoa();
        pessoa.setCep("1111111");
        pessoa.setCodigoTipoEndereco(1);
        pessoa.setIdade(25);
        pessoa.setNome("Eduardo");
        pessoa.setNomeEndereco("São Paulo");
        pessoa.setNumero("555");

        JPessoa pessoaSave = service.save(JEventService.from(pessoa));
        assertNotNull(pessoaSave);
        assertTrue(pessoaSave.getId() != null);
        lastCodigoSave = pessoaSave.getId();
    }

    @Test(expected = ConstraintViolationException.class)
    public void savePessoaComFalha() throws ServiceException {
        JPessoa pessoa = new JPessoa();

        JPessoa pessoaSave = service.save(JEventService.from(pessoa));
        assertNotNull(pessoaSave);
        assertTrue(pessoaSave.getId() != null);
    }
}

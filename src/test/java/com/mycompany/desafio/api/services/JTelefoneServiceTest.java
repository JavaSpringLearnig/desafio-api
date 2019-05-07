package com.mycompany.desafio.api.services;

import com.mycompany.desafio.api.base.dto.JDTOUtils;
import com.mycompany.desafio.api.base.exception.ServiceException;
import com.mycompany.desafio.api.base.service.JEventService;
import com.mycompany.desafio.api.dtos.JTelefoneDto;
import com.mycompany.desafio.api.entities.JPessoa;
import com.mycompany.desafio.api.entities.JTelefone;
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
public class JTelefoneServiceTest {

    @Autowired
    private ITelefoneService telefoneService;

    @Autowired
    private IPessoaService pessoaService;

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

            pessoaService.save(JEventService.from(pessoa));

            JTelefone telefone = new JTelefone();
            telefone.setCodigoTipoTelefone(1);
            telefone.setDdd("47");
            telefone.setDdi("55");
            telefone.setNumeroTelefone("999999999");
            telefone.setPessoa(pessoa);

            telefoneService.save(JEventService.from(telefone));

            dataLoaded = true;
        }
    }

    @Test
    public void filterTelefoneComSucesso() throws ServiceException {
        Page<JTelefone> telefones = telefoneService.filter(null, null, "");
        assertNotNull(telefones);
    }

    @Test
    public void saveTelefoneComSucesso() throws ServiceException {
        JPessoa pessoa = new JPessoa();
        pessoa.setCep("1111111");
        pessoa.setCodigoTipoEndereco(1);
        pessoa.setIdade(25);
        pessoa.setNome("Eduardo");
        pessoa.setNomeEndereco("São Paulo");
        pessoa.setNumero("555");

        pessoaService.save(JEventService.from(pessoa));

        JTelefone telefone = new JTelefone();
        telefone.setCodigoTipoTelefone(1);
        telefone.setDdd("47");
        telefone.setDdi("55");
        telefone.setNumeroTelefone("999999999");
        telefone.setPessoa(pessoa);

        JTelefone telefoneSave = telefoneService.save(JEventService.from(telefone));
        assertNotNull(telefoneSave);
        assertTrue(telefoneSave.getId() != null);
        lastCodigoSave = telefoneSave.getId();
    }

    @Test(expected = ConstraintViolationException.class)
    public void saveTelefoneComFalha() throws ServiceException {
        JTelefone telefone = new JTelefone();

        JTelefone telefoneSave = telefoneService.save(JEventService.from(telefone));
        assertNotNull(telefoneSave);
        assertTrue(telefoneSave.getId() != null);
    }

    @Test
    public void updateTelefoneComSucesso() throws ServiceException {
        JTelefone telefone = telefoneService.get(lastCodigoSave).orElse(null);
        assertNotNull(telefone);

        JTelefoneDto telefoneDto = JDTOUtils.convertToDTO(telefone, JTelefoneDto.class);
        assertNotNull(telefoneDto);

        telefoneDto.setNumeroTelefone("888888888");
        JTelefone entidade = JDTOUtils.convertToEntity(telefoneDto, JTelefone.class);
        JTelefone telefoneUpdate = telefoneService.update(JEventService.from(entidade, telefoneDto));
        assertNotNull(telefoneUpdate);
        assertTrue(telefoneUpdate.getNumeroTelefone().equalsIgnoreCase("888888888"));
    }
}

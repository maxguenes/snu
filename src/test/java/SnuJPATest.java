import com.upe.snu.context.ApplicationContext;
import com.upe.snu.context.DatabaseContext;
import com.upe.snu.jpa.entity.EstudanteEntity;
import com.upe.snu.jpa.entity.MateriaEntity;
import com.upe.snu.jpa.entity.MatriculaEntity;
import com.upe.snu.jpa.repository.EstudanteRepository;
import com.upe.snu.jpa.repository.MateriaRepository;
import com.upe.snu.jpa.repository.MatriculaRepository;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Max Guenes on 04/09/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseContext.class, loader = AnnotationConfigContextLoader.class)
public class SnuJPATest {

    private static Logger log = Logger.getLogger(SnuJPATest.class);


    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;


    @Test
    @Transactional
    @Rollback(true)
    public void testRepository() throws Exception
    {
        EstudanteEntity max = new EstudanteEntity();
        max.setNome("Max Guenes");

        max = estudanteRepository.save(max);

        log.info(max);

        MateriaEntity lpoo = new MateriaEntity();

        lpoo.setNome("LPOO");

        lpoo = materiaRepository.save(lpoo);

        MatriculaEntity matricula = new MatriculaEntity();
        matricula.setEstudante(max);
        matricula.setMateria(lpoo);
        matricula.setSemestre("2016.2");

        matricula = matriculaRepository.save(matricula);

    }
}
package lr9_2.services.interfaces;

import java.util.List;

import lr9_2.DTO.Mentoring;

public interface MentoringService {

    List<Mentoring> getAllMentoringObj();

    Mentoring createMentoringObj(Mentoring mentoring);

    Mentoring getMentoringObjById(Integer id) throws Exception;
}

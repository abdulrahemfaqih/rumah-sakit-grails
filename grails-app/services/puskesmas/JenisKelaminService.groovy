package puskesmas

import grails.gorm.services.Service

@Service(JenisKelamin)
interface JenisKelaminService {

    JenisKelamin get(Serializable id)

    List<JenisKelamin> list(Map args)

    Long count()

    void delete(Serializable id)

    JenisKelamin save(JenisKelamin jenisKelamin)

}
package puskesmas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class JenisKelaminServiceSpec extends Specification {

    JenisKelaminService jenisKelaminService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new JenisKelamin(...).save(flush: true, failOnError: true)
        //new JenisKelamin(...).save(flush: true, failOnError: true)
        //JenisKelamin jenisKelamin = new JenisKelamin(...).save(flush: true, failOnError: true)
        //new JenisKelamin(...).save(flush: true, failOnError: true)
        //new JenisKelamin(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //jenisKelamin.id
    }

    void "test get"() {
        setupData()

        expect:
        jenisKelaminService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<JenisKelamin> jenisKelaminList = jenisKelaminService.list(max: 2, offset: 2)

        then:
        jenisKelaminList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        jenisKelaminService.count() == 5
    }

    void "test delete"() {
        Long jenisKelaminId = setupData()

        expect:
        jenisKelaminService.count() == 5

        when:
        jenisKelaminService.delete(jenisKelaminId)
        sessionFactory.currentSession.flush()

        then:
        jenisKelaminService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        JenisKelamin jenisKelamin = new JenisKelamin()
        jenisKelaminService.save(jenisKelamin)

        then:
        jenisKelamin.id != null
    }
}

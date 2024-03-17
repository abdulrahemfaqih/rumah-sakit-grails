package puskesmas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PoliklinikServiceSpec extends Specification {

    PoliklinikService poliklinikService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Poliklinik(...).save(flush: true, failOnError: true)
        //new Poliklinik(...).save(flush: true, failOnError: true)
        //Poliklinik poliklinik = new Poliklinik(...).save(flush: true, failOnError: true)
        //new Poliklinik(...).save(flush: true, failOnError: true)
        //new Poliklinik(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //poliklinik.id
    }

    void "test get"() {
        setupData()

        expect:
        poliklinikService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Poliklinik> poliklinikList = poliklinikService.list(max: 2, offset: 2)

        then:
        poliklinikList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        poliklinikService.count() == 5
    }

    void "test delete"() {
        Long poliklinikId = setupData()

        expect:
        poliklinikService.count() == 5

        when:
        poliklinikService.delete(poliklinikId)
        sessionFactory.currentSession.flush()

        then:
        poliklinikService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Poliklinik poliklinik = new Poliklinik()
        poliklinikService.save(poliklinik)

        then:
        poliklinik.id != null
    }
}

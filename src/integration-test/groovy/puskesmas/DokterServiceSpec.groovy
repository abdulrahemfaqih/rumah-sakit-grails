package puskesmas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DokterServiceSpec extends Specification {

    DokterService dokterService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Dokter(...).save(flush: true, failOnError: true)
        //new Dokter(...).save(flush: true, failOnError: true)
        //Dokter dokter = new Dokter(...).save(flush: true, failOnError: true)
        //new Dokter(...).save(flush: true, failOnError: true)
        //new Dokter(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //dokter.id
    }

    void "test get"() {
        setupData()

        expect:
        dokterService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Dokter> dokterList = dokterService.list(max: 2, offset: 2)

        then:
        dokterList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dokterService.count() == 5
    }

    void "test delete"() {
        Long dokterId = setupData()

        expect:
        dokterService.count() == 5

        when:
        dokterService.delete(dokterId)
        sessionFactory.currentSession.flush()

        then:
        dokterService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Dokter dokter = new Dokter()
        dokterService.save(dokter)

        then:
        dokter.id != null
    }
}

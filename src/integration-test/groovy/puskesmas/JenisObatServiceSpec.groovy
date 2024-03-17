package puskesmas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class JenisObatServiceSpec extends Specification {

    JenisObatService jenisObatService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new JenisObat(...).save(flush: true, failOnError: true)
        //new JenisObat(...).save(flush: true, failOnError: true)
        //JenisObat jenisObat = new JenisObat(...).save(flush: true, failOnError: true)
        //new JenisObat(...).save(flush: true, failOnError: true)
        //new JenisObat(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //jenisObat.id
    }

    void "test get"() {
        setupData()

        expect:
        jenisObatService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<JenisObat> jenisObatList = jenisObatService.list(max: 2, offset: 2)

        then:
        jenisObatList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        jenisObatService.count() == 5
    }

    void "test delete"() {
        Long jenisObatId = setupData()

        expect:
        jenisObatService.count() == 5

        when:
        jenisObatService.delete(jenisObatId)
        sessionFactory.currentSession.flush()

        then:
        jenisObatService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        JenisObat jenisObat = new JenisObat()
        jenisObatService.save(jenisObat)

        then:
        jenisObat.id != null
    }
}

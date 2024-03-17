package puskesmas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ObatServiceSpec extends Specification {

    ObatService obatService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Obat(...).save(flush: true, failOnError: true)
        //new Obat(...).save(flush: true, failOnError: true)
        //Obat obat = new Obat(...).save(flush: true, failOnError: true)
        //new Obat(...).save(flush: true, failOnError: true)
        //new Obat(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //obat.id
    }

    void "test get"() {
        setupData()

        expect:
        obatService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Obat> obatList = obatService.list(max: 2, offset: 2)

        then:
        obatList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        obatService.count() == 5
    }

    void "test delete"() {
        Long obatId = setupData()

        expect:
        obatService.count() == 5

        when:
        obatService.delete(obatId)
        sessionFactory.currentSession.flush()

        then:
        obatService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Obat obat = new Obat()
        obatService.save(obat)

        then:
        obat.id != null
    }
}

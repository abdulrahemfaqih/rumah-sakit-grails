package puskesmas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PoliklinikController {

    PoliklinikService poliklinikService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond poliklinikService.list(params), model:[poliklinikCount: poliklinikService.count()]
    }

    def show(Long id) {
        respond poliklinikService.get(id)
    }

    def create() {
        respond new Poliklinik(params)
    }

    def save(Poliklinik poliklinik) {
        if (poliklinik == null) {
            notFound()
            return
        }

        try {
            poliklinikService.save(poliklinik)
        } catch (ValidationException e) {
            respond poliklinik.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'poliklinik.label', default: 'Poliklinik'), poliklinik.id])
                redirect poliklinik
            }
            '*' { respond poliklinik, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond poliklinikService.get(id)
    }

    def update(Poliklinik poliklinik) {
        if (poliklinik == null) {
            notFound()
            return
        }

        try {
            poliklinikService.save(poliklinik)
        } catch (ValidationException e) {
            respond poliklinik.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'poliklinik.label', default: 'Poliklinik'), poliklinik.id])
                redirect poliklinik
            }
            '*'{ respond poliklinik, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        poliklinikService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'poliklinik.label', default: 'Poliklinik'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'poliklinik.label', default: 'Poliklinik'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

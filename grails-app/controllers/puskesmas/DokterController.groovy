package puskesmas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DokterController {

    DokterService dokterService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond dokterService.list(params), model:[dokterCount: dokterService.count()]
    }

    def show(Long id) {
        respond dokterService.get(id)
    }

    def create() {
        respond new Dokter(params)
    }

    def save(Dokter dokter) {
        if (dokter == null) {
            notFound()
            return
        }

        try {
            dokterService.save(dokter)
        } catch (ValidationException e) {
            respond dokter.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dokter.label', default: 'Dokter'), dokter.id])
                redirect dokter
            }
            '*' { respond dokter, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond dokterService.get(id)
    }

    def update(Dokter dokter) {
        if (dokter == null) {
            notFound()
            return
        }

        try {
            dokterService.save(dokter)
        } catch (ValidationException e) {
            respond dokter.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dokter.label', default: 'Dokter'), dokter.id])
                redirect dokter
            }
            '*'{ respond dokter, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dokterService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dokter.label', default: 'Dokter'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dokter.label', default: 'Dokter'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

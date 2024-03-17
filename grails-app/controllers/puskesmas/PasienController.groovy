package puskesmas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PasienController {

    PasienService pasienService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pasienService.list(params), model:[pasienCount: pasienService.count()]
    }

    def show(Long id) {
        respond pasienService.get(id)
    }

    def create() {
        respond new Pasien(params)
    }

    def save(Pasien pasien) {
        if (pasien == null) {
            notFound()
            return
        }

        try {
            pasienService.save(pasien)
        } catch (ValidationException e) {
            respond pasien.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pasien.label', default: 'Pasien'), pasien.id])
                redirect pasien
            }
            '*' { respond pasien, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pasienService.get(id)
    }

    def update(Pasien pasien) {
        if (pasien == null) {
            notFound()
            return
        }

        try {
            pasienService.save(pasien)
        } catch (ValidationException e) {
            respond pasien.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pasien.label', default: 'Pasien'), pasien.id])
                redirect pasien
            }
            '*'{ respond pasien, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pasienService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pasien.label', default: 'Pasien'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pasien.label', default: 'Pasien'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

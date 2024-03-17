package puskesmas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ObatController {

    ObatService obatService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond obatService.list(params), model:[obatCount: obatService.count()]
    }

    def show(Long id) {
        respond obatService.get(id)
    }

    def create() {
        respond new Obat(params)
    }

    def save(Obat obat) {
        if (obat == null) {
            notFound()
            return
        }

        try {
            obatService.save(obat)
        } catch (ValidationException e) {
            respond obat.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'obat.label', default: 'Obat'), obat.id])
                redirect obat
            }
            '*' { respond obat, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond obatService.get(id)
    }

    def update(Obat obat) {
        if (obat == null) {
            notFound()
            return
        }

        try {
            obatService.save(obat)
        } catch (ValidationException e) {
            respond obat.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'obat.label', default: 'Obat'), obat.id])
                redirect obat
            }
            '*'{ respond obat, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        obatService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'obat.label', default: 'Obat'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'obat.label', default: 'Obat'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

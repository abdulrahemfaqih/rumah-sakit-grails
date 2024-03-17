package puskesmas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class JenisObatController {

    JenisObatService jenisObatService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond jenisObatService.list(params), model:[jenisObatCount: jenisObatService.count()]
    }

    def show(Long id) {
        respond jenisObatService.get(id)
    }

    def create() {
        respond new JenisObat(params)
    }

    def save(JenisObat jenisObat) {
        if (jenisObat == null) {
            notFound()
            return
        }

        try {
            jenisObatService.save(jenisObat)
        } catch (ValidationException e) {
            respond jenisObat.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'jenisObat.label', default: 'JenisObat'), jenisObat.id])
                redirect jenisObat
            }
            '*' { respond jenisObat, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond jenisObatService.get(id)
    }

    def update(JenisObat jenisObat) {
        if (jenisObat == null) {
            notFound()
            return
        }

        try {
            jenisObatService.save(jenisObat)
        } catch (ValidationException e) {
            respond jenisObat.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'jenisObat.label', default: 'JenisObat'), jenisObat.id])
                redirect jenisObat
            }
            '*'{ respond jenisObat, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        jenisObatService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'jenisObat.label', default: 'JenisObat'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'jenisObat.label', default: 'JenisObat'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

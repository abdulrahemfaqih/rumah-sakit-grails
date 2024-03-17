package puskesmas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class JenisKelaminController {

    JenisKelaminService jenisKelaminService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond jenisKelaminService.list(params), model:[jenisKelaminCount: jenisKelaminService.count()]
    }

    def show(Long id) {
        respond jenisKelaminService.get(id)
    }

    def create() {
        respond new JenisKelamin(params)
    }

    def save(JenisKelamin jenisKelamin) {
        if (jenisKelamin == null) {
            notFound()
            return
        }

        try {
            jenisKelaminService.save(jenisKelamin)
        } catch (ValidationException e) {
            respond jenisKelamin.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'jenisKelamin.label', default: 'JenisKelamin'), jenisKelamin.id])
                redirect jenisKelamin
            }
            '*' { respond jenisKelamin, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond jenisKelaminService.get(id)
    }

    def update(JenisKelamin jenisKelamin) {
        if (jenisKelamin == null) {
            notFound()
            return
        }

        try {
            jenisKelaminService.save(jenisKelamin)
        } catch (ValidationException e) {
            respond jenisKelamin.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'jenisKelamin.label', default: 'JenisKelamin'), jenisKelamin.id])
                redirect jenisKelamin
            }
            '*'{ respond jenisKelamin, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        jenisKelaminService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'jenisKelamin.label', default: 'JenisKelamin'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'jenisKelamin.label', default: 'JenisKelamin'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

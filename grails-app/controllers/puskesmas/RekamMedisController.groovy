package puskesmas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RekamMedisController {

    RekamMedisService rekamMedisService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rekamMedisService.list(params), model:[rekamMedisCount: rekamMedisService.count()]
    }

    def show(Long id) {
        respond rekamMedisService.get(id)
    }

    def create() {
        respond new RekamMedis(params)
    }

    def save(RekamMedis rekamMedis) {
        if (rekamMedis == null) {
            notFound()
            return
        }

        try {
            rekamMedisService.save(rekamMedis)
        } catch (ValidationException e) {
            respond rekamMedis.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rekamMedis.label', default: 'RekamMedis'), rekamMedis.id])
                redirect rekamMedis
            }
            '*' { respond rekamMedis, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rekamMedisService.get(id)
    }

    def update(RekamMedis rekamMedis) {
        if (rekamMedis == null) {
            notFound()
            return
        }

        try {
            rekamMedisService.save(rekamMedis)
        } catch (ValidationException e) {
            respond rekamMedis.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rekamMedis.label', default: 'RekamMedis'), rekamMedis.id])
                redirect rekamMedis
            }
            '*'{ respond rekamMedis, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rekamMedisService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rekamMedis.label', default: 'RekamMedis'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rekamMedis.label', default: 'RekamMedis'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

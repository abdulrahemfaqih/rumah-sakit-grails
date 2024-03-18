<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'pasien.label', default: 'Pasien')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <a href="#list-pasien" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                <div class="nav" role="navigation">
                    <ul>
                        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                        <li><g:link class="create" action="create"><g:message code="Tambah Pasien" args="[entityName]" /></g:link></li>
                          <li><a class="create" href="${createLink(uri: '../jenisKelamin')}"><g:message code="Tambah Jenis Kelamin"/></a></li>
                    </ul>
                </div>
            </section>
            <section class="row">
                <div id="list-pasien" class="col-12 content scaffold-list" role="main">
                    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <f:table collection="${pasienList}" />

                    <g:if test="${pasienCount > params.int('max')}">
                    <div class="pagination">
                        <g:paginate total="${pasienCount ?: 0}" />
                    </div>
                    </g:if>
                </div>
            </section>
        </div>
    </div>
    </body>
</html>
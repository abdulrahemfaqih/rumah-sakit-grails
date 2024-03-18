<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>E-Rumah Sakit</title>
</head>
<body>
<%-- <content tag="nav">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
            <li class="dropdown-item"><a href="#">App profile: ${grailsApplication.config.getProperty('grails.profile')}</a></li>
            <li class="dropdown-item"><a href="#">App version:
                <g:meta name="info.app.version"/></a>
            </li>
            <li role="separator" class="dropdown-divider"></li>
            <li class="dropdown-item"><a href="#">Grails version:
                <g:meta name="info.app.grailsVersion"/></a>
            </li>
            <li class="dropdown-item"><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
            <li class="dropdown-item"><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
            <li role="separator" class="dropdown-divider"></li>
            <li class="dropdown-item"><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
            <li class="dropdown-item"><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
            <li class="dropdown-item"><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
            <li class="dropdown-item"><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
        <ul class="dropdown-menu dropdown-menu-right">
            <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                <li class="dropdown-item"><a href="#">${plugin.name} - ${plugin.version}</a></li>
            </g:each>
        </ul>
    </li>
</content> --%>



<div id="content" role="main">
  
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="card text-white" style="background-color: #00C0EF">
                    <div class="card-body">
                        <h5 class="card-title">Jumlah Dokter</h5>
                        <h6>100</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-white" style="background-color: #00a65a">
                    <div class="card-body">
                        <h5 class="card-title">Jumlah Pasien</h5>
                        <h6>120</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-white" style="background-color: #f39c12">
                    <div class="card-body">
                        <h5 class="card-title">Jumlah Obat</h5>
                        <h6>300</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-white" style="background-color: #d9534f">
                    <div class="card-body">
                        <h5 class="card-title">Jumlah Poliklinik</h5>
                          <h6>300</h6>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

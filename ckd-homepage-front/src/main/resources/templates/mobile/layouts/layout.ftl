<#assign customStyle></#assign>
<#assign customScript></#assign>
<#macro style>
    <#assign customStyle>
        <#nested />
    </#assign>
</#macro>
<#macro script>
    <#assign customScript>
        <#nested />
    </#assign>
</#macro>

<#macro content>
    <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
        <title>test title</title>
        <#include "include/style.ftl" />
        ${customStyle}
    </head>
    <body>
        <#nested />
        <#include "include/footer.ftl" />
        <#include "include/script.ftl" />
        ${customScript}
    </body>
    </html>
</#macro>
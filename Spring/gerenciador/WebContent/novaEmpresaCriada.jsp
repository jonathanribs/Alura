<%//java server page -> JSP//
	//Isso � um scriplet
	String nomeEmpresa = (String)request.getAttribute("empresa");
	System.out.println(nomeEmpresa + " (scriplet na JSP)");
%>

<html><body> 
Empresa <%=nomeEmpresa /*out.println (nomeEmpresa); //essa � a forma completa*/ %> cadastrada com sucesso 
</body></http>				

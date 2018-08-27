<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	i
	ntegrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="../style/Template.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insurance</title>
<nav class="navbar navbar-default navbar-fixed-top">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand">Insurance and Co.</a>
	</div>
	<ul class="nav navbar-nav  navbar-right">
		<li class="active"><a href="../GetStarted">Home</a></li>
		<li><a href="../GetQoute">GetQuote</a></li>
		<li><a href="../ViewQoutes">OldQuotes</a></li>
		<li><a href="../ViewPolicies">MyPolicies</a></li>
		<%if(session.getAttribute("role")!=null&&session.getAttribute("role").equals("Admin")){ %>
	      <li><a href = "../SearchUsers">Search User</a></li>
	      <%} %>
		<li><a href="../LogOut">Logout</a></li>
	</ul>
</div>
</nav>
</head>
<body>
	This website is created in the interest of general public who shall
	have access to the contents of this website. By accessing this website
	(the " Insurance Website") and using its content, you acknowledge and
	you agree that you have read and understood the following terms of use
	and you agree to be bound by them. These terms and conditions may be
	revised at any time by updating this posting. You are bound by any such
	revisions and therefore we advise you to review these terms and
	conditions every time you use this web site. Do not access, download
	materials from this web site, if you do not agree with these terms of
	use.

	<h1>Website</h1>
	<br>
	<h1>Customer Contact</h1>
	<p>
		You authorize Insurance Co. Ltd. to call, send SMS and email on the
		contact number and email ID (made available by you on our website with
		a specific request to call back) and offer you information and
		services for the product you have opted for. You authorize us to call,
		SMS, email and get updates on Whatsapp you for the mentioned purpose
		irrespective of whether you are registered with the NDNC registry.
		
		Consent for sharing personal information: I/We, the undersigned, do
		hereby unconditionally agree, understand and consent as follows: I/We
		authorize Insurance Company Limited (RGICL) and RCL Group Entities,
		its agents/representatives and other business partners to collect and
		share the information provided by you / customer with the RCL Group
		Entities and other business partners for the purposes as detailed
		under the Privacy Policy and the Terms of Use. I/We declare and
		acknowledge that I/We have read and understood the terms of the
		Privacy Policy and Terms of Use and shall be bound by the same. We
		will also use your contact details information to: <br> - Send
		you information about products and services offered by Insurance and
		Reliance Capital Group Companies <br> - To contact you through
		SMS and email for policy reminder notices, claims processing <br>
		- To keep you updated on the insurance sector and Insurance through
		our newsletters. In event you do not wish to receive such information,
		you may unsubscribe through the facility in the email message you
		receive. 
	</p>
	<br>
	<h1>Use of the content</h1>
	<p>The content is available for informational purposes only. The
		posting of contents and access to this website does not render, either
		explicitly or implicitly, any provision of services or products by us.
		Information concerning financial products or services (including
		insurance, asset management and banking) is only available through the
		respective Insurance. All advertisements contains only an indication
		of cover offered with the products. For more information please read
		the policy wordings before concluding a sale.</p>
	<br>
	<h1>Reservation of Rights</h1>
	We reserve the right to change, modify, add to, or remove discounts,
	portions of these terms of use at any time subject to IRDAI regulations
	as amended time to time & company policy. Declaration & Warranty on
	Behalf of All Persons Proposed to be Insured with RGICL You agree to
	have read and understood the brochure, prospectus, sales literature &
	Policy wordings and confirm to abide by the same. Standing Instructions
	for auto debit of Credit Card (SICC) This standing instruction for auto
	debit is only available for payment of premium made through credit card
	and shall be subject to the terms and conditions mentioned in the
	Reliance HealthGain Policy (the Policy) The SICC request will be
	processed within 7 working days. The Company reserves its right to
	decline your request for SICC, without assigning any reason. Under
	SICC, the premium shall be debited on or prior to the premium payment
	due date. Prior to debiting the premium, SMS will be sent to your
	registered mobile no. This facility is available for the Policy with
	installment premium payment mode. The subsequent charge of premium
	shall be subject to change in applicable taxes. In the event of your
	request for SICC facility is declined due to any reason, you will be
	obligated to pay the outstanding premium through any other premium
	payment mode in accordance with the terms and conditions of the Policy.
	Non-payment of premium within due date as per the terms and conditions
	of the Policy, the Policy shall cease to operate from the unpaid
	installment due date and the Company shall not be liable for any claim
	under this Policy whatsoever. This authorization shall remain valid
	unless contrary instruction, revocation or termination of SICC issued
	by the Policyholder. Additionally in the event of any claim being
	logged under the policy for any cause whatsoever, all the subsequent
	premium installments shall immediately become due and payable
	notwithstanding anything to the contrary herein above contained. The
	company shall have the right to recover and deduct any or all the
	pending installments from the claim amount due under the policy.
	Disclaimer TO THE FULLEST EXTENT PERMISSIBLE PURSUANT TO APPLICABLE
	LAW, THE MATERIALS ON THIS WEBSITE ARE PROVIDED "AS IS" AND WITHOUT
	WARRANTIES OF ANY KIND EITHER EXPRESSED OR IMPLIED AND RELIANCE GENERAL
	INSURANCE COMPANY LTD. AND ITS AND AFFILIATES, DISCLAIM ALL WARRANTIES,
	EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, IMPLIED WARRANTIES
	OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. Insurance does
	not warrant that the functions contained in the materials will be
	uninterrupted or error-free, that defects will be corrected, or that
	this website or the server that makes it available are free of viruses
	or other harmful components. Insurance does not warrant or make any
	representations regarding the use or the results of the use of the
	materials on this website in terms of their correctness, accuracy,
	reliability, or otherwise. You (and not Insurance) assume the entire
	cost of all necessary servicing, repair, or correction. The in
	formation and descriptions contained herein are not intended to be
	complete descriptions of all terms, exclusions and conditions
	applicable to the products and services, but are provided solely for
	general informational purposes. This website may be linked to other
	websites which are not maintained by Insurance. Insurance is not
	responsible for the content of those websites. The inclusion of any
	link to such websites does not imply approval of or endorsement by
	Insurance of the websites or the content thereof.
	</p>
	<h1>No warranty</h1>
	<p>Although the information contained in the Website has been
		carefully vetted, the use of this website shall be at your own risk.
		All contents on the Insurance Website, including but not limited to
		graphics, text and hyperlinks or references to other sites, is
		provided "as is". Insurance shall not give without warranty of any
		kind, express or implied, including, but not limited to, implied
		warranties of merchantability, fitness for a particular purpose,
		non-infringement and freedom from computer viruses or other harmful
		components. We shall not be responsible or liable for the
		authenticity, accuracy, completeness, errors, omission, typographic
		errors, disruption, delay, interruption, failure, deletion, defect of
		any information, research, reports, analysis, quotes etc in this Web
		Site or any part thereof. We assume no responsibility to update or
		amend the website. We do not warrant that the functions of the
		Insurance website will be uninterrupted and/or error-free, that
		defects will be corrected or that the Insurance website or the server
		that makes it available are free from computer viruses or other
		harmful components.</p>
	<br>
	<h1>Credit/ Debit card details</h1>
	<p>You agree, understand and confirm that the credit card details
		provided by you for availing of services on Insurance Company Ltd.
		will be correct and accurate and you shall not use any credit card
		which is not lawfully owned by you. You further agree and undertake to
		provide the correct and valid credit card details to Insurance Company
		Ltd. Further the said information will be not be utilized and shared
		by Insurance Company Ltd. with any third parties unless required by
		law, regulation or court order. "We as a merchant shall be under no
		liability whatsoever in respect of any loss or damage arising directly
		or indirectly out of the decline of authorization for any Transaction,
		on Account of the Cardholder having exceeded the preset limit mutually
		agreed by us with our acquiring bank from time to time.</p>
	<br>
	<h1>Refund & Cancellations:</h1>
	<p>You can get in touch with our Customer Care at 1800 3009 or
		email to lolateservices@GMAIL.COM to initiate the process. Please be
		informed that cancellations will be subject to the terms and
		conditions of the policy opted by the customers.</p>
	<br>
	<h1>Limitation of Liability</h1>
	<p>Insurance assumes no liability and shall not be responsible as
		to the errors or omissions which may occur sometimes. Insurance
		expressly disclaim any liability, whether in contract, tort, strict
		liability or otherwise, for any direct, indirect, incidental,
		consequential, punitive or special damages arising out of or in any
		way connected with your access or use or inability to access or use of
		the Insurance website or reliance on its content, or any failure of
		performance, interruption, defect, delay in transmission, computer
		viruses or other harmful components, or line or system failure
		associated with the Insurance website, regardless of our knowledge
		thereof. Insurance shall not be liable for, any damages to, or viruses
		that may infect, your computer equipment or other property as a result
		of your access to, use of, or browsing in the website or your
		downloading of any materials, data, text, images, video, or audio from
		this website</p>
	<br>
	<h1>Copyright</h1>
			<p>All content of the Insurance Website is protected by copyright
				with all rights reserved. All rights in the pages, site content and
				arrangement are owned by Insurance Company. You are prohibited from
				copying, modifying, displaying, distributing, transmitting,
				redelivering through the use of "framing" technology, publishing,
				selling, licensing, creating derivative works or using any site
				content for any purpose without the prior written approval of
				Insurance Company Limited.</p>
			<br>
			<h1>Governing Law and Jurisdiction</h1>
			<p>This web site is controlled and operated by Insurance from its
				offices within the India. Any claim relating to, and the use of,
				this web site are governed by the Indian laws.</p>
			<br>
			<h1>Jurisdiction</h1>
			<p>All Disputes arising out of these terms or this website shall
				be litigated in, and only in, courts located in Mumbai, India, and
				you agree to submit to the exclusive jurisdiction of those courts.</p>
			<br>
			<h1>Severability</h1>
			<p>If any part of these Terms and Conditions are determined to be
				invalid or unenforceable pursuant to applicable law including, but
				not limited to, the warranty disclaimers and liability limitations
				set forth above, then the invalid or unenforceable provision will be
				deemed superseded by a valid, enforceable provision that most
				closely matches the intent of the original provision and the
				remainder of the Terms and Conditions shall continue in effect.</p>
			<br>
			<h1>Entire Agreement</h1>
			<p>This Agreement constitutes the entire agreement between you
				and Insurance with respect to your access to and/or use of this web
				site.</p>
</body>
</html>
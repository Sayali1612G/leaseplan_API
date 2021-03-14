@Leaseplan 
Feature: Lease Plan API Test Scenraios

Scenario Outline: Check various websites endpoint by hitting any api password utility link and doing some metadata and content verifications with very generic reusable steps.

	Given User will provide baseURI "<baseURI>"
	When User will get a <statusCode> status code 
	Then User will verify content of weburi "<Search>"
	
	
	Examples: 
		| baseURI                                                 |  statusCode |  Search                   |
		| http://ww25.passwordutility.net/api/password/generate   |        200  |  text/html; charset=UTF-8 |
	 	| http://ww25.passwordutility.net/api                     |        403  |  text/html; charset=UTF-8 |
To prevent Broken Authentication:
Model access controls should enforce record ownership rather than accepting that the user can create, read, update, or delete any record.
Disable web server directory listing and ensure file metadata (e.g., .git) and backup files are not present within web roots.
Log access control failures, alert admins when appropriate (e.g., repeated failures).
Stateful session identifiers should be invalidated on the server after logout. Stateless JWT tokens should rather be short-lived so that the window of opportunity for an attacker is minimized. For longer lived JWTs it's highly recommended to follow the OAuth standards to revoke access.


To prevent Cryptographic Failures:
Classify data processed, stored, or transmitted by an application. Identify which data is sensitive according to privacy laws, regulatory requirements, or business needs.
Don't store sensitive data unnecessarily. Discard it as soon as possible or use PCI DSS compliant tokenization or even truncation. Data that is not retained cannot be stolen.
Make sure to encrypt all sensitive data at rest.
Disable caching for response that contain sensitive data.
Store passwords using strong adaptive and salted hashing functions with a work factor (delay factor), such as Argon2, scrypt, bcrypt or PBKDF2.
Always use authenticated encryption instead of just encryption.
Avoid deprecated cryptographic functions and padding schemes, such as MD5, SHA1, PKCS number 1 v1.5 .


To prevent injection:
The preferred option is to use a safe API, which avoids using the interpreter entirely, provides a parameterized interface, or migrates to Object Relational Mapping Tools (ORMs).
Use LIMIT and other SQL controls within queries to prevent mass disclosure of records in case of SQL injection.
For any residual dynamic queries, escape special characters using the specific escape syntax for that interpreter.

To prevent Insecure Design:
Establish and use a secure development lifecycle with AppSec professionals to help evaluate and design security and privacy-related controls
Establish and use a library of secure design patterns or paved road ready to use components
Integrate security language and controls into user stories
Write unit and integration tests to validate that all critical flows are resistant to the threat model. Compile use-cases and misuse-cases for each tier of your application.
Limit resource consumption by user or service

To prevent Security Misconfiguration:
A repeatable hardening process makes it fast and easy to deploy another environment that is appropriately locked down. Development, QA, and production environments should all be configured identically, with different credentials used in each environment. This process should be automated to minimize the effort required to set up a new secure environment.
A minimal platform without any unnecessary features, components, documentation, and samples. Remove or do not install unused features and frameworks.
An automated process to verify the effectiveness of the configurations and settings in all environments.

To prevent Vulnerable and Outdated Components:
Remove unused dependencies, unnecessary features, components, files, and documentation.
Only obtain components from official sources over secure links. Prefer signed packages to reduce the chance of including a modified, malicious component.
Monitor for libraries and components that are unmaintained or do not create security patches for older versions. If patching is not possible, consider deploying a virtual patch to monitor, detect, or protect against the discovered issue.

To prevent Identification and Authentication Failures:
Where possible, implement multi-factor authentication to prevent automated credential stuffing, brute force, and stolen credential reuse attacks.
Do not ship or deploy with any default credentials, particularly for admin users.
Implement weak password checks, such as testing new or changed passwords against the top 10,000 worst passwords list.
Ensure registration, credential recovery, and API pathways are hardened against account enumeration attacks by using the same messages for all outcomes.
Use a server-side, secure, built-in session manager that generates a new random session ID with high entropy after login. Session identifier should not be in the URL, be securely stored, and invalidated after logout, idle, and absolute timeouts.

To prevent Software and Data Integrity Failures:
Use digital signatures or similar mechanisms to verify the software or data is from the expected source and has not been altered.
Ensure libraries and dependencies, such as npm or Maven, are consuming trusted repositories. If you have a higher risk profile, consider hosting an internal known-good repository that's vetted.
Ensure that a software supply chain security tool, such as OWASP Dependency Check or OWASP CycloneDX, is used to verify that components do not contain known vulnerabilities
Ensure that there is a review process for code and configuration changes to minimize the chance that malicious code or configuration could be introduced into your software pipeline.
Ensure that unsigned or unencrypted serialized data is not sent to untrusted clients without some form of integrity check or digital signature to detect tampering or replay of the serialized data.

To prevent Security Logging and Monitoring Failures:
Ensure all login, access control, and server-side input validation failures can be logged with sufficient user context to identify suspicious or malicious accounts and held for enough time to allow delayed forensic analysis.
Ensure that logs are generated in a format that log management solutions can easily consume.
Ensure log data is encoded correctly to prevent injections or attacks on the logging or monitoring systems.
Ensure high-value transactions have an audit trail with integrity controls to prevent tampering or deletion, such as append-only database tables or similar.
DevSecOps teams should establish effective monitoring and alerting such that suspicious activities are detected and responded to quickly.

To prevent Server-Side Request Forgery:
Implementing some or all the following defense in depth controls:
From Network layer:
	Enforce “deny by default” firewall policies or network access control rules to block all but essential intranet traffic.
From Application layer:
	Sanitize and validate all client-supplied input data
	Enforce the URL schema, port, and destination with a positive allow list
	Do not send raw responses to clients
	Disable HTTP redirections
	Be aware of the URL consistency to avoid attacks such as DNS rebinding and “time of check, time of use” (TOCTOU) race conditions
Do not mitigate SSRF via the use of a deny list or regular expression. Attackers have payload lists, tools, and skills to bypass deny lists.

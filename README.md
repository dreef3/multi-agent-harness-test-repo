# Multi-Agent Harness Test Repository

This repository is used for E2E testing of the Multi-Agent Harness project.

It contains a minimal Spring Boot application for testing agent capabilities.

Implemented changes (feature branch):

- Added a new search endpoint on OwnerController: GET /owners/search?lastName=<name>
  - Returns a list of Owner entities matching the provided last name.
- Added unit tests (OwnerControllerTest) using MockMvc to verify the search endpoint.
- Added top-of-file and inline comments to clarify new/changed code.

How to build and run tests locally:

- Build and run tests with Maven:

  mvn -B -DskipTests=false clean test

Notes:

- No additional configuration is required. The project uses an in-memory H2 database for tests.

Branch: feature/impl-health-endpoint

This change adds a simple health/info REST endpoint used by E2E tests.

Endpoint:
  GET /api/health

Response (JSON):
  {
    "status": "ok",
    "service": "petclinic",
    "timestamp": "<ISO8601>"
  }

Notes:
- HealthService builds the response and is injected into HealthController.
- Implemented under the existing project package com.example.petclinic to ensure Spring component scanning.
- No CI or workflow files were modified.

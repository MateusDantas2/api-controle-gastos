package br.com.demtech.controller;

import br.com.demtech.domain.entity.Release;
import br.com.demtech.dto.ResponseStandard;
import br.com.demtech.service.ReleaseService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Mateus Dantas
 */
@RestController
@RequestMapping("/release")
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;

    @PostMapping(value = "/createRelease", produces = "application/json")
    public ResponseEntity<ResponseStandard> createRelease(@Valid @RequestBody Release release, HttpServletResponse response) {
        ResponseStandard responseStandard = releaseService.createRelease(release, response);
        return ResponseEntity.ok().body(responseStandard);
    }

    @GetMapping
    public ResponseEntity<List<Release>> listReleases() {
        List<Release> releases = releaseService.listReleases();
        return ResponseEntity.ok().body(releases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Release> listReleaseById(@PathVariable @Positive Long id) {
        Release release = releaseService.listReleaseById(id);
        return ResponseEntity.ok(release);
    }
}

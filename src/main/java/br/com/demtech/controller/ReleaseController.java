package br.com.demtech.controller;

import br.com.demtech.domain.entity.Release;
import br.com.demtech.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public ResponseEntity<List<Release>> listReleases() {
        List<Release> releases = releaseService.listReleases();
        return ResponseEntity.ok().body(releases);
    }
}

package com.wallet.document.controller;

import com.wallet.document.model.GovtIdDetails;
import com.wallet.document.service.GovtIdDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/govt-id")
public class GovtIdDetailsController {

    @Autowired
    private GovtIdDetailsService govtIdDetailsService;

    @GetMapping
    public ResponseEntity<List<GovtIdDetails>> getAllGovtIds() {
        List<GovtIdDetails> govtIds = govtIdDetailsService.getAllGovtIds();
        return new ResponseEntity<>(govtIds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GovtIdDetails> getGovtIdById(@PathVariable Long id) {
        Optional<GovtIdDetails> govtId = govtIdDetailsService.getGovtIdById(id);
        return govtId.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<GovtIdDetails> createGovtId(@RequestBody GovtIdDetails govtIdDetails) {
        GovtIdDetails savedGovtId = govtIdDetailsService.saveGovtId(govtIdDetails);
        return new ResponseEntity<>(savedGovtId, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGovtId(@PathVariable Long id) {
        govtIdDetailsService.deleteGovtId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

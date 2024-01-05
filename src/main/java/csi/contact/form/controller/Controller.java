package csi.contact.form.controller;

import csi.contact.form.entity.Entity;
import csi.contact.form.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private Service service;

    @PostMapping
    public ResponseEntity<String> submitContactForm(@RequestBody Entity contact) {

        System.out.println("Nom: " + contact.getName());
        System.out.println("Prénom: " + contact.getFirstname());
        System.out.println("Nom de votre société: " + contact.getCompany());
        System.out.println("Numéro: " + contact.getPhone());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Type de site souhaité: " + contact.getSite());
        System.out.println("Détails: " + contact.getMessage());

        String to = contact.getEmail();
        String subject = "Récapitulatif Formulaire de Contact CSI";
        String body = "Nom: " + contact.getName() + "\nPrénom: " + contact.getFirstname() + "\nEmail: " + contact.getEmail() + "\nDétails: " + contact.getMessage() + "\nNuméro de téléphone: " + contact.getPhone() + "\nNom de votre société: " + contact.getCompany()+ "\nType de site souhaité: " + contact.getSite();
        service.sendEmail(to, subject, body);
        return ResponseEntity.ok("Formulaire soumis avec succès !");
    }
    }

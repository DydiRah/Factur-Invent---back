package facture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import facture.Modele.Proforma;
import facture.Repos.ProformaRepository;
import facture.Service.EmailService;

@RestController
@CrossOrigin("*")
public class ProformaController {
    @Autowired
    ProformaRepository proformaRepository;
    @Autowired
    EmailService emailService;

    @GetMapping("/proformas")
    public List<Proforma> getProforma(){
        return proformaRepository.findAll();
    }

    @PostMapping("/proformas")
    public ResponseEntity<String> insertProforma(String email, String message, String article) {
        Proforma pr = new Proforma();
        try {
            pr.setArticle(article);
            pr.setEmail(email);
            pr.setMessage(message);
            proformaRepository.save(pr);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>("Demande envoyé", HttpStatus.OK);
    }

    @DeleteMapping("/proformas")
    public void suppressDemande(Integer demande_id){
        proformaRepository.deleteById(demande_id);
    }

    @PostMapping(path = "/proformas/response/{demande_id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public void response(@PathVariable(value="demande_id") Integer demande_id, String message, String subject, MultipartFile pdf){

        Proforma p = proformaRepository.findById(demande_id).orElse(null);
        System.out.println(pdf.getOriginalFilename());
        emailService.sendEmail(subject, message, p.getEmail(), pdf);
        //proformaRepository.delete(p);
    }
    
}
package sn.gestion.post.service;

import sn.gestion.post.model.Utilisateur;

public interface ApplicationService {
    public Utilisateur findByUsername(String username);
}

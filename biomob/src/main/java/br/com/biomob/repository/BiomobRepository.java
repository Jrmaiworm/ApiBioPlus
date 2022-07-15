package br.com.biomob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biomob.entity.Locais;

public interface BiomobRepository extends JpaRepository<Locais, String> {

}

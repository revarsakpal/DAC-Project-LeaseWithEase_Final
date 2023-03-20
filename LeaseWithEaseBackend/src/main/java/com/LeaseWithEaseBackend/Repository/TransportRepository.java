package com.LeaseWithEaseBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeaseWithEaseBackend.Model.Transporter;

public interface TransportRepository extends JpaRepository<Transporter,Integer > {

}

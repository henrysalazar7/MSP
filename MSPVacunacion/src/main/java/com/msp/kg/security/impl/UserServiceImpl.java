package com.msp.kg.security.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.msp.kg.model.Rol;
import com.msp.kg.model.Usuario;
import com.msp.kg.repository.IRolRepo;
import com.msp.kg.repository.IUsuarioRepo;

@Service
public class UserServiceImpl implements UserDetailsService {

	private static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	private String ROLE_PREFIX = "ROLE_";

	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private IRolRepo rolRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario us = repo.findByNombre(username);
		if (us != null) {
			List<Rol> rolesList = rolRepo.findAllRolesByUsername(username);
			List<GrantedAuthority> rolesGranted = new ArrayList<>();
			for (Rol rol : rolesList) {
				LOG.info(rol.getNombre());
				rolesGranted.add(new SimpleGrantedAuthority(ROLE_PREFIX + rol.getNombre()));
			}
			return new User(us.getNombre(), us.getClave(), rolesGranted);
		} else {
			throw new UsernameNotFoundException("Usurio no encontrado");
		}
	}
}

package com.idm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.abstractClasses.TrenoBuilderAbstract;
import com.idm.config.Beans;
import com.idm.interfaces.Vagone;
import com.idm.service.TrenoService;

@Component
public class FrecciaRossaBuilder extends TrenoBuilderAbstract {
	
	
	    @Autowired
	    private VagoneRistorante vagoneRistorante;

	    @Autowired
	    private Locomotiva locomotiva;

	    @Autowired
	    private VagonePasseggeri vagonePasseggeri;

	    @Autowired
	    private VagoneCargo vagoneCargo;

	    @Override
	    protected AbstractVagone getCostruisciVagoneCargo() {
	    	System.out.println(vagoneCargo);
	        return vagoneCargo;
	    }

	    @Override
	    protected AbstractVagone getCostruisciLocomotiva() {
	    	System.out.println(locomotiva);
	        return locomotiva;
	    }

	    @Override
	    protected AbstractVagone getCostruisciVagoneRistorante() {
	    	System.out.println(vagoneRistorante);
	        return vagoneRistorante;
	    }

	    @Override
	    protected AbstractVagone getCostruisciVagonePasseggieri() {
	    	System.out.println(vagonePasseggeri);
	        return vagonePasseggeri;
	    }

}

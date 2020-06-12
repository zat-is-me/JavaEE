/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassfish.movieplex7.batch;

import java.util.StringTokenizer;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import org.glassfish.movieplex7.entities.Sales;

/**
 *
 * @author Tatek_Ahmed
 */
@Named
@Dependent
public class SalesProcessor implements ItemProcessor {

    @Override
    public Sales processItem(Object s) {
        Sales sales = new Sales();
        StringTokenizer tokens = new StringTokenizer((String) s, ",");
        sales.setId(Integer.parseInt(tokens.nextToken()));
        sales.setAmount(Float.parseFloat(tokens.nextToken()));
        return sales;
    }

}

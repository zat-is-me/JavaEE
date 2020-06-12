/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassfish.movieplex7.json;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import org.glassfish.movieplex7.entities.Movie;

/**
 *
 * @author Tatek_Ahmed
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class MovieReader implements MessageBodyReader<Movie> {

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return Movie.class.isAssignableFrom(type);
    }

    @Override
    public Movie readFrom(Class<Movie> type, Type type1,Annotation[] antns,MediaType mt, MultivaluedMap<String, String> mm,InputStream in)
            throws IOException, WebApplicationException {
       
        Movie movie = new Movie();
        
        JsonParser parser = Json.createParser(in);
        while (parser.hasNext()) {
            switch (parser.next()) {
                case KEY_NAME:
                    String key = parser.getString();
                    parser.next();
                    switch (key) {
                        case "id":
                            movie.setId(parser.getInt());
                            break;
                        case "name":
                            movie.setName(parser.getString());
                            break;
                        case "actors":
                            movie.setActors(parser.getString());
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        return movie;
    }
}

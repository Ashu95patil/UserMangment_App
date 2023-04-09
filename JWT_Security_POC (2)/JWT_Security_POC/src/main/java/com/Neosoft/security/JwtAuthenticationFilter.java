package com.Neosoft.security;

import com.Neosoft.model.User;
import com.Neosoft.payloads.AppConstants;
import com.Neosoft.repository.RoleRepo;
import com.Neosoft.repository.UserRepo;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.modelmapper.spi.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Value("${Salary_Limit_Exceed}")
    private Double salary;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    /*

        String requestToken = request.getHeader(AppConstants.HEADER_STRING);
        Enumeration<String> headerNames = request.getHeaderNames();


        while (headerNames.hasMoreElements()) {
            logger.info(headerNames.nextElement());
        }
        logger.info("print requestToken :" + requestToken);

        String username = null;
        String token = null;

        if (requestToken != null && requestToken.startsWith(AppConstants.TOKEN_PREFIX)) {
            token = requestToken.substring(AppConstants.TOKEN_INDEX);

            try {
                username = this.jwtTokenHelper.getUsernameFromToken(token);
            } catch (IllegalArgumentException e) {
                logger.error("Unable to get Jwt token" + e.getMessage());
            } catch (ExpiredJwtException e) {
                logger.error("Jwt token has expired" + e.getMessage());
            } catch (MalformedJwtException e) {
                logger.error("invalid jwt" + e.getMessage());
            }
        } else {
            logger.warn("Jwt token does not begin with Bearer");
        }
        // Now we get the token ,validate first
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (this.jwtTokenHelper.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } else {
                logger.info("Invalid JWT Token");
            }

        } else {
            logger.info("username is null or context is not null");
        }
        filterChain.doFilter(request, response);
    */

        HttpServletRequest req = request;
        HttpServletResponse res = response;

        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(request);

        String authToken = request.getHeader(AppConstants.HEADER_STRING).substring(AppConstants.TOKEN_INDEX);
        String[] split_string = authToken.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];

        Base64 base64Url = new Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        String body1 = new String(base64Url.decode(base64EncodedBody));

        JSONObject payload = new JSONObject(body1);


        String userSalary = payload.get("salary").toString();
        List<User> salary1 = this.userRepo.findBySalary(salary);



        if (request.getMethod().equalsIgnoreCase("POST") ||
                request.getMethod().equalsIgnoreCase("PUT")) {

            if (request.getRequestURI().toString().contains("/Users/")) {
                String[] urlSplits = request.getRequestURI().split("/");
                String user_Id = urlSplits[urlSplits.length - 1];
                if (isNumeric(user_Id)) {
                    if (!salary1.contains(Long.parseLong(userSalary))) {
                        ErrorMessage errorMessage = new ErrorMessage("Operation Not Allowed and User Has ");
                        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        PrintWriter writer = res.getWriter();
                        writer.write(String.valueOf(errorMessage));
                        writer.flush();
                        return;


                    } else {
                        filterChain.doFilter(wrapper, response);
                    }
                } else {
                    filterChain.doFilter(wrapper, response);
                }
            }

        }
    }
}


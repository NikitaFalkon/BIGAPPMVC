package com.Service;

import com.Model.User;
import com.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    private long CLIENT_ID_HOLDER;

    public boolean create(User client) {
        final long clientId = ++CLIENT_ID_HOLDER;
        client.setId(clientId);
        //client.setPassword(passwordEncoder.encode(client.getPassword()));
        // client.setRoles(Collections.singleton(Role.ADMIN));
        userRepository.save(client);
        return true;
    }



    public List<User> readAll() {
        return userRepository.findAll();
    }


    public User read(long id) {
        return userRepository.findById(id).orElseThrow();
    }

/*    public boolean update(User client, long id) {
        //Client client1 = clientRepository.findById(id).orElseThrow();
        User client1 = userRepository.findUserById(id);
        if (client1!=null)
        {
            BeanUtils.copyProperties(client, client1, "id");
            //client1.setPassword(passwordEncoder.encode(client1.getPassword()));
            userRepository.save(client1);

            return true;
        }
        return false;
    }
    public User login(User client)
    {
        User client1 =  loadUserByUsername(client.getUsername());
        if (client1!=null && client1.getPassword().equals(client.getPassword())){
            return client;
        }
        return null;
    }

    public boolean delete(long id) {
        userRepository.deleteById(id);
        return true;
    }
    public boolean deleteAll() {
        userRepository.deleteAll();
        return true;
    }
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        User client1 = userRepository.findByUsername(s);
        return client1;
    }*/
}

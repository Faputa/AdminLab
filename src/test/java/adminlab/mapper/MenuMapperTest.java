package adminlab.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import adminlab.model.Menu;

@SpringBootTest
public class MenuMapperTest {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    void save() {
        Menu memu = new Menu();
        menuMapper.save(memu);
    }

    @Test
    void delete() {
        menuMapper.delete(0L);
    }

    @Test
    void update() {
        menuMapper.update(new Menu());
    }

    @Test
    void get() {
        menuMapper.get(0L);
    }

    @Test
    void list() {
        menuMapper.list(null);
    }

}

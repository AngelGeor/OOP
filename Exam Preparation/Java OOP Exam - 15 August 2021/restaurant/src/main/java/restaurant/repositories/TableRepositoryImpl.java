package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;

import restaurant.repositories.interfaces.TableRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TableRepositoryImpl implements TableRepository<Table> {
    Map<Integer, Table> tables;

    public TableRepositoryImpl() {
        this.tables = new LinkedHashMap<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(this.tables.values());
    }

    @Override
    public void add(Table table) {
    this.tables.put(table.getTableNumber(), table);
    }

    @Override
    public Table byNumber(int number) {
        return tables.get(number);
    }
}

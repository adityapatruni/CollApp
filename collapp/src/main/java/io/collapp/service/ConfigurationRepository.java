
package io.collapp.service;

import io.collapp.model.ConfigurationKeyValue;
import io.collapp.model.Key;
import io.collapp.query.ConfigurationQuery;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
@Transactional(readOnly = true)
public class ConfigurationRepository {

	private final ConfigurationQuery queries;

	public ConfigurationRepository(ConfigurationQuery queries) {
		this.queries = queries;
	}

	public List<ConfigurationKeyValue> findAll() {
		return queries.findAll();
	}

	public Map<Key, String> findConfigurationFor(Set<Key> keys) {
		Set<String> s = new HashSet<>();
		Map<Key, String> res = new EnumMap<>(Key.class);
		for (Key k : keys) {
			s.add(k.toString());
			res.put(k, null);
		}

		for (ConfigurationKeyValue kv : queries.findConfigurationFor(s)) {
			res.put(kv.getFirst(), kv.getSecond());
		}
		return res;
	}

	public boolean hasKeyDefined(Key key) {
		return !Integer.valueOf(0).equals(queries.hasKeyDefined(key.toString()));
	}

	public String getValueOrNull(Key key) {
		List<String> res = queries.getValue(key.toString());
		return res.isEmpty() ? null : res.get(0);
	}

	public String getValue(Key key) {
		List<String> res = queries.getValue(key.toString());
		if (res.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		} else {
			return res.get(0);
		}
	}

	@Transactional(readOnly = false)
	public void insert(Key key, String value) {
		queries.set(key.toString(), value);
	}

	@Transactional(readOnly = false)
	public void update(Key key, String value) {
		queries.update(key.toString(), value);
	}

	@Transactional(readOnly = false)
	public void delete(Key key) {
		queries.delete(key.toString());
	}

	@Transactional(readOnly = false)
	public void updateOrCreate(List<ConfigurationKeyValue> toUpdateOrCreate) {
		for (ConfigurationKeyValue kv : toUpdateOrCreate) {
			if (hasKeyDefined(kv.getFirst())) {
				update(kv.getFirst(), kv.getSecond());
			} else {
				insert(kv.getFirst(), kv.getSecond());
			}
		}
	}
}

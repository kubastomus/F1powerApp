package pl.kubastomus.f1powerapp;

import java.util.Objects;

public class SeasonDTO {

    private int idSeason;

    public SeasonDTO() {
    }

    public SeasonDTO(int idSeason) {
        this.idSeason = idSeason;
    }

    public int getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(int idSeason) {
        this.idSeason = idSeason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeasonDTO seasonDTO = (SeasonDTO) o;
        return idSeason == seasonDTO.idSeason;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeason);
    }
}

const confirmAction = () => {
    if (window.confirm("¿Estás seguro de que deseas realizar esta acción?")) {
      // El usuario hizo clic en "Aceptar"
      // Aquí puedes realizar la acción que se confirma
      console.log("La acción se realizó.");
    } else {
      // El usuario hizo clic en "Cancelar" o cerró el cuadro de diálogo
      // Aquí puedes manejar el caso en el que el usuario cancela la acción
      console.log("La acción se canceló.");
    }
  };
